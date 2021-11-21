package ru.netology.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public class Issue {
    private int id;
    private String name;
    private boolean open;
    private String author;
    private ArrayList<String> label;
    private String assignee;
    private int timeFromOpen;

    public Issue(int id, String name, boolean open, String author, ArrayList<String> label, String assignee, int timeFromOpen) {
        this.id = id;
        this.name = name;
        this.open = open;
        this.author = author;
        this.label = label;
        this.assignee = assignee;
        this.timeFromOpen = timeFromOpen;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return open;
    }

    public String getAuthor() {
        return author;
    }

    public ArrayList<String> getLabel() {
        return label;
    }

    public String getAssignee() {
        return assignee;
    }

    public int getTimeFromOpen() {
        return timeFromOpen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLabel(ArrayList<String> label) {
        this.label = label;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setTimeFromOpen(int timeFromOpen) {
        this.timeFromOpen = timeFromOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return id == issue.id && open == issue.open && timeFromOpen == issue.timeFromOpen && Objects.equals(name, issue.name) && Objects.equals(author, issue.author) && Objects.equals(label, issue.label) && Objects.equals(assignee, issue.assignee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, open, author, label, assignee, timeFromOpen);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", open=" + open +
                ", author='" + author + '\'' +
                ", label=" + label +
                ", assignee='" + assignee + '\'' +
                ", timeFromOpen=" + timeFromOpen +
                '}';
    }

}
