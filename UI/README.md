[![Website narrowcaster.ga](https://img.shields.io/website-up-down-green-red/https/narrowcaster.ba99.nl.svg)](https://narrowcaster.ga/)

# Narrowcaster Admin Panel
_This project works with the [Narrowcaster Api](https://github.com/brann0n/narrowcaster/API). This admin panel allows the admin to configure the dashboards displayed using the narrowcasting service._

![dashboard-example](docs/img/dashboard-example.png?raw=true "Dashboard Example")

The first requirement is that the API has successfully been installed and is operational. You can check for operationality by going to the `/swagger-ui.html` page.

Assuming you cloned the repo during the installation of the API, open a terminal and navigate to the UI folder.

Now run the following command `npm install` to install the dependecies of the React project. _(The project was last built on march 8th 2025 using node22)_  

With the open cmd tab (where the path should end with the name of your favourite root folder where you installed the project) type the following command: `npm install` and pressing `enter`. This may take a minute or two. Do not close the window, you will need it after the configuration part.

## Configuration
To setup the project, we need to set some configuration values in order to work correctly. These values have to be stored in an `env.json` file.
- Create your own `env.json` file in the UI folder
- Set the values from the example below according to your environment.
  ```json
  {
    "REACT_APP_DATA_URL": "http://localhost:8080",
    "REACT_APP_AUTH_URL": "http://localhost:8080/authenticate",
    "REACT_APP_SCREEN_AUTH_URL": "http://localhost:8080/authenticate_screen"
  }
  ```
- Save the file

The `REACT_APP_DATA_URL` is the url where the api is served. The other URLS tell the UI where to send the authentication requests to.

## Run the project
In the console window that we left open before the configuration part, we can start the project. Start the Admin Panel by typing the following command: `npm start`. This can also take a minute or two. When this is finished you can navigate to `http://localhost:5173`. Your browser should show the welcome screen like the screenshot below.

![welcome-screen](docs/img/welcome-screen.png "Welcome Screen")

When you click on the `Go to admin panel` button, you will be redirected to the login screen [http://localhost:5173/#!/login](http://localhost:5173/#!/login)

![login-screen](docs/img/login-screen.png "Login Screen")

The default username and password are what you configured when setting up the API. (If you followed the installation guide they are, `admin` and `changeme`.) After logging in, its adviced that you first of all change the username and password. You can now use the project to show information on a screen. To view the information, the slides should be linked to a slideshow which should be linked to a screen. The screen provides you with an unique auth key. For instance `AdyXwfnFSBY2oN4TjubQmCE6PRnFt535`. The key can be added to the base url with a `/#!/` in the middle like so: http://localhost:5173/#/AdyXwfnFSBY2oN4TjubQmCE6PRnFt535. It's now possible to view the slideshow.
