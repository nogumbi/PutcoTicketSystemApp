import json
import os

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


def options(phone_number, pin):
    """
    Options available
    """
    menu = int(input("""Main menu: \n
    1. Register
    2. Login
    3. Exit
    """))
    os.system("clear")
    if menu == 1:
        registration(phone_number, pin)
    elif menu == 2:
        login()
    else:
        print("Goodbye")
        exit()



def registration(phone_number, pin):
    """
    Process of storing new users details to the data.json
    """
    dict_['cellnumber'] = phone_number
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
    exit()


def login(phone_number):
    """
    Accessing the json file to match the number
    entered to the pin
    """
    try:
        data = json.load(storage_file)
        if data['cellnumber'] == phone_number:
            pinverify = input("Please enter pin: ")
            os.system("Clear.")

            count = 3
            while data['pin'] != pinverify:
                pinverify = input("Incorect pin, please re-enter pin: ")
                count = count -1
                if count == 0:
                    print("Account locked due to security.")
                    exit()
                else:
                    print("Welcome back!")
                    options()
                    exit(0)
    except json.decoder.JSONDecodeError:
        pass


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
    print("Bus tag number xxx-xxx-xxxx refill. ")
    pass


if __name__ == '__main__':
    print("Welcome to the Putco Electronic Refill System.\n \n")
    create_num()