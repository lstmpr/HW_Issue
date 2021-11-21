package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerTest {
    private IssueManager manager = new IssueManager(new IssueRepository());

    List<Issue> list = new ArrayList<>();


    @Test
    void shouldSaveAll() {
        ArrayList<String> label = new ArrayList<>(Arrays.asList("bug", "enhancement", "new feature", "question", "task"));

        list.add(new Issue(1, "Bug", true, "Ekaterina", new ArrayList<String>(Arrays.asList("bug")), "Mike", 70));
        list.add(new Issue(2, "Error", false, "Nika", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Pavel", 90));
        list.add(new Issue(3, "Something", false, "Stanislav", new ArrayList<String>(Arrays.asList("task")), "Oleg", 88));
        list.add(new Issue(4, "Question", true, "Anna", new ArrayList<String>(Arrays.asList("question")), "Mike", 15));

        manager.saveAll(list);
        assertEquals(4, manager.findAll().size());

    }

    @Test
    void shouldGetAllOpen() {

        Issue first = new Issue(1, "Bug", true, "Ekaterina", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Mike", 70);
        Issue second = new Issue(2, "Error", false, "Nika", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Pavel", 90);
        Issue third = new Issue(3, "Something", false, "Stanislav", new ArrayList<String>(Arrays.asList("task")), "Oleg", 88);
        Issue fourth = new Issue(4, "Question", true, "Anna", new ArrayList<String>(Arrays.asList("question")), "Mike", 15);

        Collection<Issue> expected = new ArrayList<>();
        expected.add(first);
        expected.add(fourth);

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.getAllOpen();

        assertEquals(expected, manager.getAllOpen());

    }

    @Test
    void shouldGetAllClosed() {

        Issue first = new Issue(1, "Bug", true, "Ekaterina", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Mike", 70);
        Issue second = new Issue(2, "Error", false, "Nika", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Pavel", 90);
        Issue third = new Issue(3, "Something", false, "Stanislav", new ArrayList<String>(Arrays.asList("task")), "Oleg", 88);
        Issue fourth = new Issue(4, "Question", false, "Anna", new ArrayList<String>(Arrays.asList("question")), "Mike", 15);

        Collection<Issue> expected = new ArrayList<>();
        expected.add(second);
        expected.add(third);
        expected.add(fourth);

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.getAllClosed();

        assertEquals(expected, manager.getAllClosed());

    }

    @Test
    void shouldFilterByAuthor() {

        Issue first = new Issue(1, "Bug", true, "Ekaterina", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Mike", 70);
        Issue second = new Issue(2, "Error", false, "Stanislav", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Pavel", 90);
        Issue third = new Issue(3, "Something", false, "Stanislav", new ArrayList<String>(Arrays.asList("task")), "Oleg", 88);
        Issue fourth = new Issue(4, "Question", false, "Anna", new ArrayList<String>(Arrays.asList("question")), "Mike", 15);

        Collection<Issue> expected = new ArrayList<>();
        expected.add(second);
        expected.add(third);

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);


        assertEquals(expected, manager.filterByAuthor("Stanislav"));

    }

    @Test
    void shouldFilterByLabel() {

        Issue first = new Issue(1, "Bug", true, "Ekaterina", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Mike", 70);
        Issue second = new Issue(2, "Error", false, "Stanislav", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Pavel", 90);
        Issue third = new Issue(3, "Something", false, "Stanislav", new ArrayList<String>(Arrays.asList("task")), "Oleg", 88);
        Issue fourth = new Issue(4, "Question", false, "Anna", new ArrayList<String>(Arrays.asList("question")), "Mike", 15);

        Collection<Issue> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);


        assertEquals(expected, manager.filterByLabel("enhancement"));

    }


    @Test
    void shouldFilterByAssignee() {

        Issue first = new Issue(1, "Bug", true, "Ekaterina", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Mike", 70);
        Issue second = new Issue(2, "Error", false, "Stanislav", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Pavel", 90);
        Issue third = new Issue(3, "Something", false, "Stanislav", new ArrayList<String>(Arrays.asList("task")), "Oleg", 88);
        Issue fourth = new Issue(4, "Question", false, "Anna", new ArrayList<String>(Arrays.asList("question")), "Mike", 15);

        Collection<Issue> expected = new ArrayList<>();
        expected.add(first);
        expected.add(fourth);

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);


        assertEquals(expected, manager.filterByAssignee("Mike"));

    }

    @Test
    void shouldCloseById() {

        Issue first = new Issue(1, "Bug", true, "Ekaterina", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Mike", 70);
        Issue second = new Issue(2, "Error", true, "Stanislav", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Pavel", 90);
        Issue third = new Issue(3, "Something", false, "Stanislav", new ArrayList<String>(Arrays.asList("task")), "Oleg", 88);
        Issue fourth = new Issue(4, "Question", true, "Anna", new ArrayList<String>(Arrays.asList("question")), "Mike", 15);

        Collection<Issue> expected = new ArrayList<>();
        expected.add(third);
        expected.add(fourth);

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);

        manager.closeById(4);


        assertEquals(expected, manager.getAllClosed());

    }

    @Test
    void shouldOpenById() {

        Issue first = new Issue(1, "Bug", true, "Ekaterina", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Mike", 70);
        Issue second = new Issue(2, "Error", true, "Stanislav", new ArrayList<String>(Arrays.asList("enhancement", "new feature")), "Pavel", 90);
        Issue third = new Issue(3, "Something", false, "Stanislav", new ArrayList<String>(Arrays.asList("task")), "Oleg", 88);
        Issue fourth = new Issue(4, "Question", true, "Anna", new ArrayList<String>(Arrays.asList("question")), "Mike", 15);

        Collection<Issue> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);
        expected.add(third);
        expected.add(fourth);

        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);

        manager.openById(3);


        assertEquals(expected, manager.getAllOpen());

    }


}