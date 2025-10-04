package entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Engine {
	
	@Id
    private int engineId;
    private int cc;

    public Engine() {
    }

    public int getEngineId() {
        return engineId;
    }

    public void setEngineId(int engineId) {
        this.engineId = engineId;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "Engine {" +
                "engineId=" + engineId +
                ", cc=" + cc +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineId, cc);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Engine))
            return false;
        Engine other = (Engine) obj;
        return engineId == other.engineId && cc == other.cc;
    }
}
