# ONLINE GROCERY STORE

Model this as a set of Java classes, with at least the following:

 

● Store, that manages Carts, and has Billers and Packers.

● Item - the items sold in the store - which have a name and price-per-unit

● Perishables and Non-Perishables, that can appropriately provide weight or volume as appropriate, as well as other properties specific to their types, in addition to all the information available for Items

● Cart: provides separate methods to add Perishables and Non-perishables, specifying the number of units of each item being ordered. Can be queried for list of ordered Items, or specifically for Perishable and non-Perishable items

The main reads in data to mimic the actions of a customer: adds various items and specifies the quantity of each item being ordered. Perishables are sold by weight (kgs) and Non-Perishables by number of units.
When the user requests checkout, the store calls the biller to process the cart, who computes the total cost of all the items in the cart, and adds the shipping estimate given by the Packer, and prints out a detailed bill.

The shipping cost is computed by the Packer. Today’s deal provides free shipping upto 5 kgs of perishables and Rs. 5 per kg beyond that. Shipping for non-perishables is at Rs. 2 per liter beyond the first 4 liters. (This can change periodically and is typically known only to the Packer dept).
Below are the input formats as well as sample input and output. You can assume that vegetables, fruits and dairy products are perishables, and all other items are categorized as non-perishables.
The input first lists the set of Items available at the store, and contains the name and unit-price of each item, and for non-perishables, additionally, the volume (in liters) of each unit. An “End” indicates the end of the list of items. This is followed by a series of lines that represent the actions of a single user, and each line lists the name of an item, and the number of units (or weight) of items bought. A “Checkout” indicates that shopping is completed and checkout can be done.
