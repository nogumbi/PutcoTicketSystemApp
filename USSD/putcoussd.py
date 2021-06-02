import json

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
    pass

def registration():
    """
    Process of storing new users details to the data.json
    """
    print("Registering...")
    print("Successfully registered...")
    pass

def login():
    """
    Accessing the json file to match the number
    entered to the pin
    """
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