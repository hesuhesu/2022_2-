import Module1

order1 = Module1.Order()

print(order1._Order__price)
order1.printInfo()

order2 = Module1.Order("latte", 10000)
print(order2._Order__price)
order2.printInfo()

Module1.publicFunc()
Module1._privateFunc()