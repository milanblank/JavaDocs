package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;

/**
 * Created by Milan on 12-Jul-17.
 */
public class Department {

    @Id(name = "department_id")
    private long id;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "location")
    private Location location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Department o = (Department) obj;

        if (this.getId() == o.getId()
                && this.getDepartmentName().equals(o.departmentName)
                && location.equals(o))
            return true;

        return false;
    }

    @Override
    public String toString() {
        return this.getId() + " "
                + this.getDepartmentName() + " "
                + location.toString();
    }
}
