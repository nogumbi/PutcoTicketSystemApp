
import routeprices
import unittest
import putcoussd
import routepositions
from unittest.mock import patch
from io import StringIO


class Test(unittest.TestCase):
    # Tests if the bus number has 10 digits
    @patch("sys.stdin", StringIO("123454568\nforwar\n123456789"))
    def test_numberofdigits(self):
        code = putcoussd.create_num()
        self.assertEqual(len(code),9)
        self.assertEqual(code, "123454568")
    
    # Tests the pin number
    @patch("sys.stdin", StringIO("11245\nforwar\n12345"))
    def test_pin(self):
        code = putcoussd.create_pin()
        self.assertEqual(len(code), 5)
        self.assertEqual(code, "11245")

    def test_positions(self):
        position = 1234
        self.assertEqual(1234, 1234)


if __name__ == '__main__':
    unittest.main()