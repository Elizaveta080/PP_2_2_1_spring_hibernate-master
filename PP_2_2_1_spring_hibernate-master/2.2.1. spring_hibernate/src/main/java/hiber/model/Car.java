package hiber.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long car_id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {

    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Long getCar_id(){
        return car_id;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }
    @Override
    public String toString() {
        return "Car{" +
                "series=" + series +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getSeries() == car.getSeries() && Objects.equals(getCar_id(), car.getCar_id()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(user, car.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCar_id(), getModel(), getSeries(), user);
    }

}
