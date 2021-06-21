import json
import os
import time

# Stores data of the person
storage_file = open("data.json", "r+")


dict_ = {}


def create_num():
    """
    Inputs the 9 digit cellphone number 
    file after registeration for later use.
    """
    phone_num = input("Please enter your phone number (+27 __ ___ ____): ")
    if len(phone_num) != 9 or not phone_num.isdigit():
        print("Invalid Phone Number.\n")
        return create_num()
    else:
        print(f'+27 {phone_num}')
        return (f'+27 {phone_num}')


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
    menu = int(input("""Main menu: \n
    1. Refill
    2. Link Card
    4. Check days left
    3. Exit
    """))
    os.system("clear")
    if menu == 1:
        refill()
    elif menu == 2:
        linkcard()
    else:
        print("Goodbye")
        exit()


def registration(phone_number):
    """
    Process of storing new users details to the data.json
    """
    dict_['cellnumber'] = phone_number
    pin = create_pin()
    repeat_pin = input("Please re-enter pin: ")
    while pin != repeat_pin:
        repeat_pin = ("PIN does not match. Please re-enter pin: ")
    dict_['pin'] =  pin
    dict_['linked'] = False

    userInfo = json.dumps(dict_)
    storage_file.write("")
    storage_file.write(userInfo)
    print("Registering...")
    print("Successfully registered...")
    options()


def verification(phone_number):
    """
    Accessing the json file to match the number
    entered to the pin
    """
    
    data = json.load(storage_file)
    if data['cellnumber'] == phone_number:
        pinverify = input("Please enter pin: ")
        os.system("clear.")

        count = 3
        if data['pin'] != pinverify:
            pinverify = input("Incorect pin, please re-enter pin: ")
            count = count -1
            if count == 0:
                print("Account locked due to security.")
                exit()
        else:
            print("Welcome back!")
            options()
            exit(0)


def login(phone_number):
    option = int(input(" 1. Register\n 2. Login\n 3. Exit\n"))
    os.system("clear")
    if option == 1:
        registration(phone_number)
    elif option == 2:
        verification(phone_number)
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
    tag = input("Enter bus tag number: ")
    occurrance = int(input("1. Weekly\n2. Monthly\n3. Termly\n"))
    if occurrance == 1:
        weekly = input("Weekly tag is R250. Confirm? (y/n) \n")
        if weekly == "y":
            print("Card refilled for one week.")
        else:
            exit()
    elif occurrance == 2:
        weekly = input("Monthly tag is R900. Confirm? (y/n) \n")
        if weekly.islower() == "y":
            time.sleep(3)
            print("Card refilled for one month.")
        else:
            exit()
    elif occurrance == 3:
        weekly = input("Termly tag is R2700. Confirm? (y/n) ")
        if weekly.islower() == "y":
            time.sleep(3)
            print("Card refilled for three months.")
        else:
            exit()
    else:
        print("Goodbye!")
        exit()

def run_ussd():
    """
    Main function for running the ussd
    """

    print("Welcome to the Putco Electronic Refill System.\n \n")
    
    phone_number = create_num()

    menu = 0
    while menu != 3:
        menu = login(phone_number)
    os.system("clear")
    print("See you soon, Goodbye!")


if __name__ == '__main__':
    run_ussd()