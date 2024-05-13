package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    void whenAscByName() {
        Comparator<Job> ascByName = new JobAscByName();
        int result = ascByName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void whenAscByPriority() {
        Comparator<Job> ascByPriority = new JobAscByPriority();
        int result = ascByPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenDescByName() {
        Comparator<Job> descByName = new JobDescByName();
        int result = descByName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenDescByPriority() {
        Comparator<Job> descByPriority = new JobDescByPriority();
        int result = descByPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenCompatorDescByNameAndPrority() {
        Comparator<Job> cmpDescNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpDescNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByNameAndPrority() {
        Comparator<Job> cmpAscNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpAscNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorDescByProrityAndAscName() {
        Comparator<Job> cmpDescPriorityAscName = new JobDescByPriority().thenComparing(new JobAscByName());
        int rsl = cmpDescPriorityAscName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorAscByPriorityAndDescName() {
        Comparator<Job> cmpAscPriorityDescName = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmpAscPriorityDescName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorPriorityIsEqualsAndDescName() {
        Comparator<Job> cmpEqualsPriorityDescName = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmpEqualsPriorityDescName.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorNamesIsEqualsAndAscPriority() {
        Comparator<Job> cmpEqualsNamesAscPriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpEqualsNamesAscPriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}