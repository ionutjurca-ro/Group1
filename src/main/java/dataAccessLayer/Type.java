package dataAccessLayer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int typeId;
    private String typeName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "type_id")
    private List<Task> tasks;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
