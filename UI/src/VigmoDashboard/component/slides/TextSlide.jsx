import React from "react";

function TextSlide(props) {
    const [text, setText] = React.useState([]);
    const [loaded, setLoaded] = React.useState(false);

    const api = props.api;
  
    React.useEffect(() => {
      api.getSlide(props.path).then((data) => {
        setText(data.data);

        if (!loaded) {
          setLoaded(true);
        }
      });
    }, []);


    if (!loaded) {
      return (
        <div className="loading-screen">
          <div>Loading...</div>
        </div>
      );
    }

    return (
        <div className="slideContent">
            <h1>{ text.title }</h1>
            <div style={{ fontSize: props.fontSize }} dangerouslySetInnerHTML={{__html: text.message}}></div>
        </div>
    );
}

export default TextSlide;