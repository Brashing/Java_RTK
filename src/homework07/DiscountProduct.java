package homework07;

import java.time.LocalDate;

public class DiscountProduct extends Product {
    private final int discountPercent; // скидка в процентах
    private final LocalDate discountPeriodEnd; // дата окончания скидки

    // Конструктор
    public DiscountProduct(String title, int value, int discountPercent, LocalDate discountPeriodEnd) {
        super(title, value);
        if (discountPercent <= 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в пределах от 1 до 100");
        }
        if (discountPeriodEnd == null || discountPeriodEnd.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Дата окончания скидки должна быть в будущем");
        }
        this.discountPercent = discountPercent;
        this.discountPeriodEnd = discountPeriodEnd;
    }

    // Получение текущей цены с учетом скидки, если она действует
    @Override
    public int getValue() {
        if (LocalDate.now().isBefore(discountPeriodEnd) || LocalDate.now().isEqual(discountPeriodEnd)) {
            // Действует скидка
            int discountedPrice = getOriginalValue() * (100 - discountPercent) / 100;
            return Math.max(discountedPrice, 0);
        } else {
            return getOriginalValue();
        }
    }
    // Это оригинальная цена без скидки
    public int getOriginalValue() {
        return super.getValue();  // или хранить отдельное поле-оригинальную цену
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public LocalDate getDiscountPeriodEnd() {
        return discountPeriodEnd;
    }

    @Override
    public String toString() {
        return "DiscountProduct{" +
                "название='" + getTitle() + '\'' +
                ", исходная цена=" + getOriginalValue() +
                ", скидка=" + discountPercent + "%" +
                ", срок скидки=" + discountPeriodEnd +
                '}';
    }
}