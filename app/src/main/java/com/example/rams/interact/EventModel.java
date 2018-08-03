package com.example.rams.interact;

public class EventModel {
    String eventtitle,eventdes,eventdate,location,organisers;

    public EventModel(String eventtitle, String eventdes, String eventdate, String location, String organisers) {
        this.eventtitle = eventtitle;
        this.eventdes = eventdes;
        this.eventdate = eventdate;
        this.location = location;
        this.organisers = organisers;
    }

    public String getEventtitle() {
        return eventtitle;
    }

    public void setEventtitle(String eventtitle) {
        this.eventtitle = eventtitle;
    }

    public String getEventdes() {
        return eventdes;
    }

    public void setEventdes(String eventdes) {
        this.eventdes = eventdes;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrganisers() {
        return organisers;
    }

    public void setOrganisers(String organisers) {
        this.organisers = organisers;
    }
}
