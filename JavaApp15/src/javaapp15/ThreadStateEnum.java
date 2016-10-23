package javaapp15;

public enum ThreadStateEnum {
    START(1) {
        String getDescription() {
            return "Запуск потока";
        }

        public String toString() {
            return "Старт";
        }
    }, RUNNING(2) {
        String getDescription() {
            return "Работа потока";
        }

        public String toString() {
            return "Запуск";
        }
    }, WAITING(3) {
        String getDescription() {
            return "Поставили на паузу";
        }

        public String toString() {
            return "Ожидание";
        }
    }, DEAD(4) {
        String getDescription() {
            return "Убили поток";
        }

        public String toString() {
            return "Остановка";
        }
    };

    private int priority;

    abstract String getDescription();

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    private ThreadStateEnum(int priority) {
        this.priority = priority;

    }

    @Override
    public String toString() {
        return "Переопределенный метод. Приоритет равен " + priority;
    }
}
