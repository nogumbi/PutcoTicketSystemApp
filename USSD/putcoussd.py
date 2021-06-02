import json

# Stores data of the person
storage_file = open("data.json", "r+")

dict_ = {}


def create_num():
    """
    Inputs the 9 digit cellphone number 
    file after registeration for later use.
    """
    phone_num = input("Please enter your phone number (+27 __ ___ ____):")
    while len(phone_num) != 9 or not phone_num.isdigit():
        print("Invalid Entry")
        phone_num = input("Please enter your phone number (+27 __ ___ ____)")

    return phone_num

def create_pin():
    pass

if __name__ == '__main__':
    print("Welcome to the Putco Electronic Refill System.\n \n")
    create_num()