import React from "react";

function RssSlide(props) {
  const [rss, setRss] = React.useState([]);
  const [loaded, setLoaded] = React.useState(false);

  const api = props.api;

  React.useEffect(() => {
    api.getSlide(props.path + '/latest').then((data) => {
      setRss(data.data);

      if (!loaded) {
        setLoaded(true);
      }
    });
  }, []);

  function footInfo(rss) {
    let append = null;
    if (rss.author !== null) {
      append = <em><b>Auteur:</b> {rss.author}</em>
    }
    return append
  }

  if (!loaded) {
    return (
      <div className="loading-screen">
        <div>Loading...</div>
      </div>
    );
  }

  return (
    <div className="slideContent" style={{ padding: 0, overflow: 'hidden' }}>
      <div className="rssWrapper">
        <h2>{rss.title}</h2>
        <em className="textMuted">{rss.category}</em>
        <div className="rssImageWrapper">
          <img src={rss.image} className="rssImage"></img>
        </div>
        <p className="rssDescriptionWrapper" dangerouslySetInnerHTML={{ __html: rss.description }} />
        <div className="rssFootInfo">
          {footInfo(rss)}
        </div>
      </div>
    </div>
  );
}

export default RssSlide;