# Al-Akeel-Food-Ordering
Tools Project - Al Akeel Food Ordering Platform
Project Name
Introduction
The Al-Akeel Company has developed an online order management platform over the past 15 years. This platform enables users to place online orders to registered restaurants from a list of available options. It also facilitates the tracking and delivery of orders from the restaurant's locations to the customers. The platform serves clients through a dedicated mobile application, web app, or customer service assistance over the phone. Additionally, the platform provides restaurant staff with the ability to manage specific orders for their establishments. Integration with Bank Misr serves as the payment gateway for online transactions, while the integration with Aramex shipment company manages the delivery of orders. Recently, the company has encountered reliability issues, occasional downtime, and slow response times. Moreover, they face the challenge of incorporating mobile payment options and utilizing Al-Akeel's own shipment fleet alongside the existing Aramex shipment service.

Entities
The following entities are central to the system:

User: Contains the fields "Id," "name," and "role."
Meal: Contains the fields "id," "name," "price," and "fk_restaurantId."
Order: Contains the fields "Id," "Item array," "total_price," "fk_runnerId," "fk_restaurantId," and "order_status" (preparing, delivered, canceled).
Runner: Contains the fields "Id," "name," "status" (available, busy), and "delivery_fees."
Restaurant: Contains the fields "Id," "name," "ownerId," and a list of meals.
Note: Additional fields can be added as needed.
System Functionalities
The platform provides the following functionalities based on user roles:

User
Users can have three different roles: Customer, Restaurant Owner, and Runner.

Sign up and Login for each role:
Note: When creating a runner account, users can enter a delivery fee per order. This value will be used when calculating the total order value.
Restaurant Owner
Create restaurant menu.
Edit restaurant: Change menu meals for each restaurant.
Get restaurant details by ID.
Create restaurant report: Given a restaurant ID, generate a report containing the total earnings (sum of the total amounts from all completed orders), number of completed orders, and number of canceled orders.
Customer
Create an order: Customers can place orders, which include the order date, restaurant name, item list, delivery fees, runner name, and total receipt value (sum of item prices and delivery fees).
List orders by customer ID.
When creating an order, a random available runner is assigned from the database, and their status is updated to busy.
Edit an order: Customers can modify an order's items. This is only possible if the order is not canceled and is in the preparing state.
List all restaurants.
Runner
Mark an order as delivered and update the runner's status to available.
Get the number of completed trips for a runner: This is determined by counting the number of orders marked as completed that were not canceled.
Feel free to make any necessary modifications or additions to the above description to suit your specific project.




