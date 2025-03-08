import React from "react";
import { useState } from "react";
import { useDate } from "../logic/currentTime";
import "./SideBarPanel.css";
import { colors } from "../config/colors";

const SideBarPanel = () => {

    const { date, time, wish } = useDate();
    const [currentDisplay, setCurrentDisplay] = useState({
        text: "Hello, " + " Customers!",
        greeting: true
    });

    const changeGreeting = () => {

        const dateTimeString = date + " " + time;
        const greetingString = wish + " Customers!";

        if (dateTimeString === currentDisplay.text || greetingString === currentDisplay.text) {
            //this means no useDate() update was issued: 
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
            //this means the time changed and the component wants to update.
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
        <div className="component-sidebar" style={{ backgroundColor: colors.offWhite }}>
            <div >
                {currentDisplay.text}
            </div>
        </div>
    );
}

export default SideBarPanel;