package org.moera.naming.data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.moera.naming.rpc.Rules;

@Embeddable
public class NameGeneration implements Serializable {

    private static final long serialVersionUID = -6236816230823929126L;

    @NotNull
    @Size(max = Rules.NAME_MAX_LENGTH)
    private String name;

    @NotNull
    private int generation;

    public NameGeneration() {
        this("", 0);
    }

    public NameGeneration(String name) {
        this(name, 0);
    }

    public NameGeneration(String name, int generation) {
        this.name = name;
        this.generation = generation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, generation);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NameGeneration)) {
            return false;
        }
        NameGeneration peer = (NameGeneration) obj;
        return Objects.equals(name, peer.name) && generation == peer.generation;
    }

}
