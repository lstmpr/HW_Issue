package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssueRepository {
    private Collection<Issue> issues = new ArrayList<Issue>();

    public void save(Issue issue) {
        issues.add(issue);
    }

    public void removeById(int id) {
        issues.removeIf(element -> element.getId() == id);
    }

    public void saveAll(Collection<Issue> issues) {
        this.issues.addAll(issues);
    }

    public boolean remove(Issue issue) {
        return issues.remove(issue);
    }

    public Collection<Issue> findAll() {
        return issues;
    }

    public boolean removeAll(Collection<Issue> issues) {
        return this.issues.removeAll(issues);
    }


}
