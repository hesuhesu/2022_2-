print("__name__ : ",__name__)

def func1() :
    print("Module1.py의 func1()가 호출됨.")
def func2() :
    print("Module1.py의 func2()가 호출됨.")
def func3() :
    print("Module1.py의 func3()가 호출됨.")

def publicFunc() :
    print("this is public")
def _privateFunc() :
    print("this is private")

class Order :
    def __init__ (self, coffee = "Americano", price = 5000):
        self.coffee = coffee
        self.__price = price
    def printInfo(self):
        print("{}는 {}원입니다.".format(self.coffee, self.__price))

O = Order()

if __name__ == "__main__" :
    print("--------------------")
    func1()
    publicFunc()
    _privateFunc()
    print("--------------------")
    Order("latte").printInfo()
    Order("Americano", 10000).printInfo()
    O.printInfo()
    print("--------------------")