package architecture.items;

public class Taskbook extends RoomItem {
    private boolean isOpen;

    public Taskbook() {
        this.isOpen = false;
    }

    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("задачник открыт");
        } else {
            System.out.println("задачник уже открыт");
        }
    }

    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("задачник закрыт");
        } else {
            System.out.println("задачник уже закрыт");
        }
    }

    public void solveTask(String description) {
        if (!isOpen) {
            System.out.println("откройте задачник, чтобы решить задачу");
            return;
        }

        // локальный класс для решения задачи
        class Task {
            private String description;

            public Task(String description) {
                this.description = description;
            }

            public void complete() {
                System.out.println("задача \"" + description + "\" выполнена");
            }
        }

        Task task = new Task(description);
        task.complete();
    }

    // статический вложенный класс для описания состояния задачи
    public static class TaskState {
        private boolean isCompleted;

        public TaskState(boolean isCompleted) {
            this.isCompleted = isCompleted;
        }

        public boolean isCompleted() {
            return isCompleted;
        }

        public void setCompleted(boolean completed) {
            isCompleted = completed;
        }

        @Override
        public String toString() {
            return isCompleted ? "задача завершена" : "задача не завершена";
        }
    }

    @Override
    public String toString() {
        return "задачник ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taskbook taskbook = (Taskbook) o;
        return this.hashCode() == taskbook.hashCode();
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}