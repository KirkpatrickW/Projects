# setup the list to append information too
record_list = []

# read in the data file, ignoring the '# comments' and append to a list
def read_data():
    infile = open("RECORD_DATA.txt", 'r')

    for row in infile:
        start = 0                                           # Starts from the current position in each line.
        string_builder = []                                 # List to hold each row.
        if not row.startswith('#'):                         # Ignores any comments.
            for index in range(len(row)):
                if  row[index] == ',' or index == len(row)-1:
                    string_builder.append(row[start:index]) # List builder.
                    start = index + 1
            record_list.append(string_builder)              # Add list to outer list.
    infile.close()
read_data()

# Menu
def main():
    print("--------------------------------------------------------------------Menu Selected----------------------------------------------------------------")
    print("     BASIC FEATURES")
    print("     1. Output a list of record titles and their respective details, including a summary report displaying (a) the total number of titles in stock and (b) the value of records in stock.")
    print("     2. Output a list of record titles and their respective details which are above a user provided price threshold.")
    print("     3. Output a report giving the number of records existing in each genre type.")

    print("\n     ADVANCED FEATURES")
    print("     4. Option to add a new record and present a summary report displaying (a) the new total number of titles in stock and (b) the new total value of records in stock. The record which you should add is one copy of the LP Radio Silence, by the Neil Cowley Trio at £12.99. The Neil Cowley Trio is a Jazz group.")
    print("     5. Query if a record title is available and present option of (a) increasing stock level or (b) decreasing the stock level, due to a sale. If the stock level is decreased to zero indicate to the user that the record is currently out of stock.")
    print("     6. Plot a labelled bar chart that presents the number of titles existing in each genre type.")

    print("\n     7. Quit")
    print("-------------------------------------------------------------------------------------------------------------------------------------------------")
    
    menu_option = int(input("\nWhat would you like to do?"))        # Stores the user entered integer to be used to select a menu option.

    # Option 1
    def print_summary():
        if menu_option == 1:
            print("----------------------------------------------------------------Option 1 Selected----------------------------------------------------------------")

            total_cost = 0                # This sets the initial total cost to zero as its not been found yet.
            for item in range(len(record_list)):                                            # This displays all the items in the list with commas seperating them.
                print(record_list[item][0], record_list[item][1], record_list[item][2], record_list[item][3], record_list[item][4], record_list[item][5], record_list[item][6], sep=', ')
                total_records = len(record_list)                                            # This counts the total number of records.
                total_cost += float(record_list[item][6]) * int(record_list[item][5])       # This calculates the total cost of all the records.

            print('\nThere are', total_records, 'records in total')
            print('The total cost of all records is £',format(total_cost,'.2f'))

            print("-------------------------------------------------------------------------------------------------------------------------------------------------")
            
            # Return to the menu.
            menu_return = input("\nEnter Y if you wish to return to the menu, otherwise enter any input to exit the program: ")
            if menu_return == "y" or menu_return == "Y":        # If "y" or "Y" is entered it will return to menu.
                return main()
            else:                                               # If anything other than "Y" or "y" is entered it will exit the application.
                print("Have a nice day!")
                quit()
    print_summary()

    # Option 2
    def print_price():
        if menu_option == 2:
            print("----------------------------------------------------------------Option 2 Selected----------------------------------------------------------------")
            price_threshold = float(input("Enter the minimum price threshold: "))

            for item in record_list:      # This finds all the items that have a value greater than the one specified.
                if float(item[6]) > price_threshold:
                    print(item)

            print("-------------------------------------------------------------------------------------------------------------------------------------------------")

            # Return to the menu.
            menu_return = input("\nEnter Y if you wish to return to the menu, otherwise enter any input to exit the program: ")
            if menu_return == "y" or menu_return == "Y":        # If "y" or "Y" is entered it will return to menu.
                return main()
            else:                                               # If anything other than "Y" or "y" is entered it will exit the application.
                print("Have a nice day!")
                quit()
    print_price()

    # Option 3
    def print_genre():
        if menu_option == 3:
            print("----------------------------------------------------------------Option 3 Selected----------------------------------------------------------------")

            dict_genre = {}                 # This is a dictonary to be used to store the different types of genres and how many times they appear.

            for item in record_list:        # This finds all the different types of genre and counts how many times in appears and saves it in the dictonary.
                if item[2] in dict_genre:
                    dict_genre[item[2]] = int(dict_genre[item[2]]) + 1
                else:
                    dict_genre[item[2]] = 1
            
            for key, value in dict_genre.items():   #This seperates the keys and the values in the dictonary so it can be formatted.
                print(key + ': ', value)

            print("-------------------------------------------------------------------------------------------------------------------------------------------------")

            # Return to the menu.
            menu_return = input("\nEnter Y if you wish to return to the menu, otherwise enter any input to exit the program: ")
            if menu_return == "y" or menu_return == "Y":        # If "y" or "Y" is entered it will return to menu.
                return main()
            else:                                               # If anything other than "Y" or "y" is entered it will exit the application.
                print("Have a nice day!")
                quit()
    print_genre()

    # Option 4
    def print_newrecord():
        if menu_option == 4:
            print("----------------------------------------------------------------Option 4 Selected----------------------------------------------------------------")

            temporary_list = []                     # This creates a list for the following information to be stored for implementation into the main record list.
            
            artist = input("Enter the artist: ")
            title = input("Enter the title: ")
            genre = input("Enter the genre: ")
            play_length = input("Enter the play length: ")
            condition = input("Enter the condition: ")
            stock = input("Enter the stock: ")
            cost = input("Enter the cost: ")

            # This section appends all the information entered to a temporary list so its properly formatted to be implemeneted into the main record list.
            temporary_list.append(artist)
            temporary_list.append(title)
            temporary_list.append(genre)
            temporary_list.append(play_length)
            temporary_list.append(condition)
            temporary_list.append(stock)
            temporary_list.append(cost)

            record_list.append(temporary_list)      # This appends all the information from the temporary list to the main record list.

            total_cost = 0                # This sets the initial total cost to zero as its not been found yet.
            for item in range(len(record_list)):                                            # This displays all the items in the list with commas seperating them.
                print(record_list[item][0], record_list[item][1], record_list[item][2], record_list[item][3], record_list[item][4], record_list[item][5], record_list[item][6], sep=', ')
                total_records = len(record_list)                                            # This counts the total number of records.
                total_cost += float(record_list[item][6]) * int(record_list[item][5])       # This calculates the total cost of all the records.

            print('\nThere are', total_records, 'records in total')
            print('The total cost of all records is £',format(total_cost,'.2f'))

            print("-------------------------------------------------------------------------------------------------------------------------------------------------")
            
            # Return to the menu.
            menu_return = input("\nEnter Y if you wish to return to the menu, otherwise enter any input to exit the program: ")
            if menu_return == "y" or menu_return == "Y":        # If "y" or "Y" is entered it will return to menu.
                return main()
            else:                                               # If anything other than "Y" or "y" is entered it will exit the application.
                print("Have a nice day!")
                quit()
    print_newrecord()

    # Option 5
    def print_stock():
        if menu_option == 5:
            print("----------------------------------------------------------------Option 5 Selected----------------------------------------------------------------")

            record_title = " " + input("Enter in the title of a record: ")
            for item in record_list:
                if item[1] == record_title:                             # This searches for a record that matches what the user inputted.
                    print("Record Successfuly Found!")
                    print("\nYou have selected:")
                    print(item[0], item[1], item[2], item[3], item[4], item[5], item[6], sep = ', ')
                    stock_choice = input("Would you like to Increase (I) or Decrease (D) the stock: ")
                    if stock_choice == "I" or stock_choice == "i":      # If "D" or "d" is entered it will allow you to enter how much you wish to increase the stock by.
                        increase = int(input("How much would you like to increase the stock by: "))
                        item[5] = int(item[5]) + increase
                        print("\nThe new stock for", item[1], "is", item[5])
                    elif stock_choice == "D" or stock_choice == "d":    # If "D" or "d" is entered it will allow you to enter how much you wish to decrease the stock by.
                        decrease = int(input("How much would you like to decrease the stock by: "))
                        item[5] = int(item[5]) - decrease
                        if item[5] < 0:                                 # This is an error message displayed when the stock count is below zero and it also resets the value to its original.
                            print("The amount you wish to decrease the stock by is invalid as the count is below zero, Please try again.")
                            item[5] = int(item[5]) + decrease
                            return print_stock()
                        else:                                           # If there is no issues the new stock and its title will be displayed.
                            print("\nThe new stock for", item[1], "is", item[5])
                        if item[5] == 0:                                # If the record is out of stock this will be used to display a message.
                            print("This record is now currently out of stock.")
                    else:
                        print("The choice you have entered is invalid, please try again.")
                        return print_stock()

            print("-------------------------------------------------------------------------------------------------------------------------------------------------")
            
            # Return to the menu.
            menu_return = input("\nEnter Y if you wish to return to the menu, otherwise enter any input to exit the program: ")
            if menu_return == "y" or menu_return == "Y":        # If "y" or "Y" is entered it will return to menu.
                return main()
            else:                                               # If anything other than "Y" or "y" is entered it will exit the application.
                print("Have a nice day!")
                quit()
    print_stock()
            
    # Option 6
    def print_barchart():
        if menu_option == 6:
            import matplotlib.pyplot as plt  # This allows for implementation of the barchart via plt.

            dict_genre = {}                 # This is a dictonary to be used to store the different types of genres and how many times they appear.

            for item in record_list:        # This finds all the different types of genre and counts how many times in appears and saves it in the dictonary.
                if item[2] in dict_genre:
                    dict_genre[item[2]] = int(dict_genre[item[2]]) + 1
                else:
                    dict_genre[item[2]] = 1
            
            keys = dict_genre.keys()        # This seperates the names of the genres from their values.
            values = dict_genre.values()    # This seperates the values of each genre from their name.

            Colours = ['red', 'green', 'blue', 'purple', 'yellow']
            plt.bar(keys, values, color=Colours)
            plt.title('No. of Titles in each Genre', fontsize=14)
            plt.xlabel('Genres', fontsize=14)
            plt.ylabel('No. of Titles', fontsize=14)
            plt.grid(True)
            plt.show()

            # Return to the menu.
            menu_return = input("\nEnter Y if you wish to return to the menu, otherwise enter any input to exit the program: ")
            if menu_return == "y" or menu_return == "Y":        # If "y" or "Y" is entered it will return to menu.
                return main()
            else:                                               # If anything other than "Y" or "y" is entered it will exit the application.
                print("Have a nice day!")
                quit()
    print_barchart()

    # Option 7
    if menu_option == 7: 
        print("Have a nice day!")
        quit()
main()