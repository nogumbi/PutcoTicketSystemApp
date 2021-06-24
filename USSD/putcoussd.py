import json
import os
import time
import sys
import routeprices

# Stores data of the person
storage_file = open("data.json", "r+")
dict_ = {}


def create_num():
    """
    Inputs the 9 digit cellphone number 
    file after registeration for later use.
    """
    bus_num = input("Please enter your bus tag number: ")
    if len(bus_num) != 9 or not bus_num.isdigit():
        print("Invalid Bus Tag Number.\n")
        return create_num()
    else:
        return (bus_num)
    


def create_pin():
    """Creates pin for the first time
    that will be connected with the phone
    number

    Returns:
        int: pin that will be stored in the data.json as a 
        dictionary
    """
    pin = input("Please enter a 5-digit pin: ")
    if len(pin) != 5 or not pin.isdigit():
        print("Invalid pin.\n")
        return create_pin()
    else:
        return pin


def options():
    """
    Options available
    """
    menu = int(input("""Main menu:\n
    1. Refill
    2. Link Card
    3. Main Menu
    """))
    os.system("clear")
    if menu == 1:
        refill()
    elif menu == 2:
        linkcard()



def registration():
    """
    Process of storing new users details to the data.json
    """
    print("You are not registered. ")
    bus_num = create_num()
    dict_['tag_num'] = bus_num
    pin = create_pin()
    pinverify2 = input("Please re-enter pin: ")
    if pin == pinverify2:
        dict_['pin'] =  pin
    else:
        print("PIN does not match")
        pinverify = input("Please re-enter pin: ")

    userInfo = json.dumps(dict_)
    storage_file.write("")
    storage_file.write(userInfo)
    print("Registering...")
    print("Successfully registered...")
    options()


def verification():
    """
    Accessing the json file to match the number
    entered to the pin
    """
    # global storage_file
    with open('data.json') as storage_file:
        data = json.load(storage_file)
    bus_num = create_num()
    if data["tag_num"] == bus_num:
        pinverify = input("Please enter pin: ")
        # os.system("clear.")

        count = 3
        if pinverify != data["pin"]:
            pinverify = input("Incorrect pin, please re-enter pin: ")
            count = count -1
            if count == 0:
                print("Account locked due to security.")
                exit()
            else:
                print("Welcome back!")
                options()
        else:
            print("\nPIN not associated with Bus Tag Number\n\nPlease try again..")



def login():
    option = int(input("1. Register\n2. Login\n3. Exit\n"))
    os.system("clear")
    if option == 1:
        registration()
    elif option == 2:
        verification()
    else:
        exit()
        
    return option


def linkcard():
    """
    Linking bank card to refill
    """
    print("Linking card...")
    pass


def refill():
    """
    Refill to the number at the back of the bus tag
    """
    starting_point = input("Enter starting point: ")
    ending_point = input("Enter ending point: ")
    amount = routeprices.amount
    
    dict_["starting_point"] = starting_point
    dict_["ending_point"] = ending_point
    os.system("clear")
    occurrance = int(input("1. Weekly\n2. Monthly\n3. Termly\n"))
    if occurrance == 1:
        routeprices.weekly(amount)
        weekly = input("Confirm? (y/n) \n")
        if weekly == "y":
            print("Card refilled for one week.")
        else:
            refill()
    elif occurrance == 2:
        routeprices.monthly(amount)
        monthly = input("Confirm? (y/n) \n")
        if monthly == "y":
            print("Card refilled for one month.")
        else:
            refill()
    elif occurrance == 3:
        routeprices.termly(amount)
        termly = input("Confirm? (y/n) \n")
        if termly == "y":
            print("Card refilled for three months.")
        else:
            refill()
    
    os.system("clear")
    options()

    userInfo = json.dumps(dict_)
    storage_file.write("\n")
    storage_file.write(userInfo)
        

def run_ussd():
    """
    Main function for running the ussd
    """

    print("Welcome to the Putco Electronic Refill System.\n \n")
    
    
    
    menu = 0
    while menu != 3:
        menu = login()
    os.system("clear")
    print("See you soon, Goodbye!")


if __name__ == '__main__':
    run_ussd()