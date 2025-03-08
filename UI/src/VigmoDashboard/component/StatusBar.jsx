import React, { useState } from "react";
import { useDate } from "../logic/currentTime";
import "./StatusBar.css";

const StatusBar = () => {

    const { date, time, wish } = useDate();
    const [currentDisplay, setCurrentDisplay] = useState({
        text: "Hello, " + " Students!",
        greeting: true
    });

    const changeGreeting = () => {
        const dateTimeString = date + " " + time;
        const greetingString = wish + " Students!";

        if (dateTimeString === currentDisplay.text || greetingString === currentDisplay.text) {
            if (currentDisplay.greeting) {
                setCurrentDisplay({
                    text: dateTimeString,
                    greeting: false
                })
            }
            else {
                setCurrentDisplay({
                    text: greetingString,
                    greeting: true
                })
            }
        }
        else {
            if (currentDisplay.greeting) {
                setCurrentDisplay({
                    text: greetingString,
                    greeting: true
                })
            }
            else {
                setCurrentDisplay({
                    text: dateTimeString,
                    greeting: false
                })
            }
        }
    };

    //gets run after every react update.
    setTimeout(() => {
        changeGreeting(); //run greeting changer every 10 seconds
    }, 10000);

    return (
        <div className="component-statusbar">
            <div >
                {currentDisplay.text}
            </div>
        </div>
    );
}

export default StatusBar;