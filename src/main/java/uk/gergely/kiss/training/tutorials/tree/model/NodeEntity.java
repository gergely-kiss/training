package uk.gergely.kiss.training.tutorials.tree.model;

import uk.gergely.kiss.training.data.JpaConstants;

import javax.persistence.*;

@Entity(name = JpaConstants.NODE)
public class NodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = JpaConstants.ID, nullable = false)
    private Long id;

    @Column(name = JpaConstants.TREE_ID)
    private Long treeId;

    @Column(name = JpaConstants.KEY, nullable = false)
    private Integer key;

    @Column(name = JpaConstants.VALUE, nullable = false)
    private String value;

    @Column(name = JpaConstants.LEFT_CHILD_ID)
    private Long leftChildId;

    @Column(name = JpaConstants.RIGHT_CHILD_ID)
    private Long rightChildId;

    public NodeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getLeftChildId() {
        return leftChildId;
    }

    public void setLeftChildId(Long leftChildId) {
        this.leftChildId = leftChildId;
    }

    public Long getRightChildId() {
        return rightChildId;
    }

    public void setRightChildId(Long rightChildId) {
        this.rightChildId = rightChildId;
    }
}
