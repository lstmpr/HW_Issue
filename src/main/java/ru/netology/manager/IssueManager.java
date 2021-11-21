package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class IssueManager {
    private IssueRepository repository;

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public void saveAll(Collection<Issue> issues) {
        repository.saveAll(issues);

    }

    public void save(Issue issue) {
        repository.save(issue);

    }

    public Collection<Issue> findAll() {
        return repository.findAll();
    }

    public Collection<Issue> getAllOpen() {
        Collection<Issue> list = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.isOpen()) {
                list.add(issue);
            }
        }
        return list;
    }

    public Collection<Issue> getAllClosed() {
        Collection<Issue> list = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (!issue.isOpen()) {
                list.add(issue);
            }
        }
        return list;
    }


    public Collection<Issue> filterByAuthor(String author) {
        Collection<Issue> list = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.getAuthor().equals(author)) {
                list.add(issue);
            }
        }
        return list;
    }

    public Collection<Issue> filterByLabel(String label) {
        Collection<Issue> list = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            for (String currentLabel : issue.getLabel()) {
                if (currentLabel.equals(label)) {
                    list.add(issue);
                }
            }
        }
        return list;
    }

    public Collection<Issue> filterByAssignee(String assignee) {
        Collection<Issue> list = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.getAssignee().equals(assignee)) {
                list.add(issue);
            }
        }
        return list;
    }

    public void closeById(int id) {
        for (Issue issue : repository.findAll()) {
            if (issue.getId() == id) {
                issue.setOpen(false);

            }
        }
    }

    public void openById(int id) {
        for (Issue issue : repository.findAll()) {
            if (issue.getId() == id) {
                issue.setOpen(true);

            }
        }
    }


}
