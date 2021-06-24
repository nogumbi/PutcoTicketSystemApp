import routepositions

amount = routepositions.print_routes()

def weekly(amount):
    """multiply the amount with 5 days of the week

    Args:
        amount ([type]): parameter returned from the distance multiplied by the rand per kilometer
    """
    weekly = round(amount * 5, 2)
    print(f"Amount R{weekly}")

def monthly(amount):
    """multiply the amount with 20 days of the working month

    Args:
        amount ([type]): parameter returned from the distance multiplied by the rand per kilometer
    """
    monthly = round(amount * 20, 2)
    print(f"Amount R{monthly}")

def termly(amount):
    """multiply the amount with 60 days of 3 working months

    Args:
        amount ([type]): parameter returned from the distance multiplied by the rand per kilometer
    """
    termly = round(amount * 60, 2)
    print(f"Amount R{termly}")


