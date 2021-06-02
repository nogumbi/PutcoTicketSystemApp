import unittest
import putcoussd

class Test(unittest.TestCase):
    # Tests if the bus number has 10 digits
    def test_numberofdigits(self):
        for i in range(100):
            code = putcoussd.create_num()
            self.assertEqual(len(code), 10)
    
    # Tests the pin number
    def test_pin(self):
       for i in range(100):
            code = putcoussd.create_pin()
            self.assertEqual(len(code), 5)
            
if __name__ == '__main__':
    unittest.main()