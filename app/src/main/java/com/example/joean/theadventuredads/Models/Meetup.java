package com.example.joean.theadventuredads.Models;

/**
 * Created by joean on 2018-06-21.
 */

public class Meetup {

        public int meetupImage;
        public String meetupName;
        public String meetupDate;
        public String meetupLocation;


        public Meetup(int meetupImage, String meetupName, String meetupDate, String meetupLocation) {
            this.meetupImage = meetupImage;
            this.meetupName = meetupName;
            this.meetupDate = meetupDate;
            this.meetupLocation = meetupLocation;
        }
}
