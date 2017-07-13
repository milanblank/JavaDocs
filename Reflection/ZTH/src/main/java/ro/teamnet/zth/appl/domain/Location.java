package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;

/**
 * Created by Milan on 12-Jul-17.
 */
public class Location {

    @Id(name = "location_id")
    private long id;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "city")
    private String city;
    @Column(name = "state_province")
    private String stateProvince;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Location o = (Location) obj;

        if (this.getId() == o.getId() && this.getStreetAddress().equals(o.getStreetAddress())
                && this.getPostalCode().equals(o.getPostalCode())
                && this.getCity().equals(o.getCity())
                && this.getStateProvince().equals(o.getStateProvince()))
            return true;
    }

    @Override
    public String toString() {
        return this.getId() + " "
                + this.getStreetAddress() + " "
                + this.getPostalCode() + " "
                + this.getCity() + " "
                + this.getPostalCode();
    }
}
