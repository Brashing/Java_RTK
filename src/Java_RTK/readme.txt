
// Добавление опции редактирования списка продуктов при необходимости

// --- Начало вставки ---
        System.out.println("\nВы хотите изменить название продукта? (да/нет)");
        String answerChange = scanner.nextLine().trim();

        if (answerChange.equalsIgnoreCase("да")) {
            System.out.print("Введите название продукта для редактирования: ");
            String oldName = scanner.nextLine().trim();

            // Поиск продукта по имени
            Product productToEdit = null;
            for (Product p : products) {
                if (p.getTitle().equalsIgnoreCase(oldName)) {
                    productToEdit = p;
                    break;
                }
            }

            if (productToEdit == null) {
                System.out.println("Продукт с таким названием не найден.");
            } else {
                System.out.print("Введите новое название: ");
                String newTitle = scanner.nextLine().trim();

                try {
                    productToEdit.setTitle(newTitle);
                    System.out.println("Название успешно обновлено: " + productToEdit.getTitle());
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка при обновлении названия: " + e.getMessage());
                }
            }
        }
// --- Конец вставки ---