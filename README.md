# Проект библиотеки желаний на Java

### На данном проекте отработано:

---

<ul>
	<li style="font-size: 15px; font-weight: 500;">Построение приложения по принципу MVC</li>
	<ul>
		<li style="font-size: 14px; font-weight: 400;">Model
			<ul>
			  <li style="font-size: 14px; font-weight: 400;">классы, описывающие работу с БД</li>
			  <li style="font-size: 14px; font-weight: 400;">классы-Entity</li>
			</ul>
		</li>
		<li style="font-size: 14px; font-weight: 400;">View - взоимодействие с пользователем и вводимыми им данными через консоль</li>
		<li style="font-size: 14px; font-weight: 400;">Controller — сервисы, отвечающие за:
		        <ul>
		          <li style="font-size: 14px; font-weight: 400;">работу с БД (получение данных от пользователя и взаимодействие с этими данными, в т.ч. отображение view, соответствующего полученным данным)</li>
		          <li style="font-size: 14px; font-weight: 400;">валидацию и обработку данных, вводимых пользователем</li>
		          <li style="font-size: 14px; font-weight: 400;">реализацию бизнес-логики</li>
		          <li style="font-size: 14px; font-weight: 400;">отлавливание ошибок</li>
		        </ul>
	      </li>
	</ul>
	  <li style="font-size: 15px; font-weight: 500;">Построение приложения в соответствии с принципами SOLID</li>
	  <li style="font-size: 15px; font-weight: 500;">Работа с БД PostgreSQL через JDBC</li>
	  <li style="font-size: 15px; font-weight: 500;">Написание SQL-запросов</li>
	  <li style="font-size: 15px; font-weight: 500;">Отработка знаний Java Core</li>
		<ul>
			<li style="font-size: 14px; font-weight: 400;">Абстрактные классы и наследование от них</li>
			<li style="font-size: 14px; font-weight: 400;">Паттерн Singletone</li>
      			<li style="font-size: 14px; font-weight: 400;">Коллекции (листы)</li>
			<li style="font-size: 14px; font-weight: 400;">Интерфейсы как абстракции для внедрения бизнес-логики (в т.ч. через дефолтные методы)</li>
			<li style="font-size: 14px; font-weight: 400;">Создание кастомных исключений</li>
		</ul>
</ul>


### Что может делать пользователь?
<ul>
	<li style="font-size: 14px; font-weight: 500;">Регистрироваться</li>
	<li style="font-size: 14px; font-weight: 500;">Логиниться в ЛК</li>
	<li style="font-size: 14px; font-weight: 500;">Создавать вишлист</li>
	<li style="font-size: 14px; font-weight: 500;">Добавлять желания с описанием, приоритетом и ссылкой в свой вишлист</li>
</ul>
