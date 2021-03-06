package br.com.cit.logistics_center.domain.entities;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by neto on 21/06/17.
 */

/**
 * Delivery entity created on database.
 */
@Entity(name = "deliveries")
@ApiObject(name = "Delivery", description = "Delivery object")
public class Delivery {

    @Id
    @Column(name = "id")
    @ApiObjectField(description = "Delivery identificator")
    private Long deliveryId;

    @NotNull
    @Column(name = "id_vehicle")
    @ApiObjectField(description = "Vehicle identificator")
    private Long vehicle;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "deliveries_packages",
            joinColumns = {@JoinColumn(name = "id_delivery", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_package", referencedColumnName = "id")})
    private List<Package> packages;

    public Delivery(){}

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getVehicle() {
        return vehicle;
    }

    public void setVehicle(Long vehicle) {
        this.vehicle = vehicle;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }
}
