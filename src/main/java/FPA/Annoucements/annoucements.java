package FPA.Annoucements;

import java.util.Objects;

public class annoucements {
    private String annouce;

    public annoucements() {
    }

    public annoucements(String annouce) {
        this.annouce = annouce;
    }

    public String getAnnouce() {
        return annouce;
    }

    public void setAnnouce(String annouce) {
        this.annouce = annouce;
    }

    @Override
    public String toString() {
        return "annoucements{" +
                "annouce='" + annouce + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        annoucements that = (annoucements) o;
        return annouce.equals(that.annouce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annouce);
    }
}
