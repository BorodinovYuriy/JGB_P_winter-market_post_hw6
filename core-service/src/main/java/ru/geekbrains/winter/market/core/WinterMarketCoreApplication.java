package ru.geekbrains.winter.market.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WinterMarketCoreApplication {
	// План действий:
	// - + Swagger
	// - + Добавить работу с множеством корзин в редисе
	// - + Замените цены продуктов/корзин с int на BigDecimal
	// - + Добавить страницу с заказами
	// - + Добавьте фильтрацию/пагинация товаров (по цене мин/макс, названию), поговорить про спецификации
	// - Добавить правила безопасности на гейтвей (12)
	// - + Поговорить про докер
	// - Добавить платежную систему (12) / OAuth 2.0
	// - + Распилить фронт на страницы
	// - + Поговорить про работу над МСами
	// - Wiremock (12)
	// - + Поговорить про профили
	// - Иерархия товаров
	// - + Добавить пагинацию на фронт (кнопки < Пред стр, 1, 2, 3, 4, .., След стр >)

	// Домашнее задание:
	// - Весь core-service покрыть доками swagger'а
	// - * (Если докер установился) Вместо memurai подключитесь к Redis, в качестве БД для МСов используйте
	// Докер-postgresql

	public static void main(String[] args) {
		SpringApplication.run(WinterMarketCoreApplication.class, args);
	}
}
