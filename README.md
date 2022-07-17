# Bici-U

- Users are able to register themselves with a Role, their DNI, name and age, users must be 18 or older to register.
- Upon creating an user you can borrow a Bicycle, either mountain or road.
- When a bicycle is generated it will keep track of it with a ticket!
- The System provides data persistence viat xt files to keep track of generated users, lended bikes and tickets.

## Ticket System

Tickets are used to keep track of bike lending, they may have a cost if more than 30 minutes from the lending have passed, for each 30 minutes the ticket will have a cost of 3$. When users return a bike the cost of the ticket will also take into account the state of the bicycle and the helmet and update the bicycle availabilty status.

Users WONT be able to borrow bicycles if they have tickets pending for payment, users may pay theit tickets with option 4, lastly you can check the tickets generated with option 5.

Tickets can be queried by user ID or by status, you cal also show the history of all the Tickets generated.

## Known bugs 

- Users can borrow more than 1 bicycle at a time, this could be limited or disabled... but oh the time.
- Almost all of the features can handle misinputs, but options 5.2 and 5.3 will just return you to the menu with no aditional info if query is unsuccesful.

