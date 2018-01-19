class Car {
    def mile = 0
    final year
    final name = "simon"

    Car(theYear) {
        year = theYear
    }
}


Car car = Car(2018)

println "Year:${car.year}"
println "mile:${car.mile}"
println "set mile"
car.mile = 25
println "mile:${car.mile}"


def map = [:]
def firstName = "simon"
map."key" = "value"
map."${firstName}" = "hello"
assert firstName == "hello"

def eagerGString = "value == ${firstName}"
def lazyGString = "value == ${-> firstName}"

def escapeSlash = /the name is simon /
BigInteger bi = 6   //无限精度

byte xByte = 0b11   //二进制以 0b 开头
int xInt = 077      //八进制以 0 开头

int yInt = 2 ** 3   //幂运算   8
int zInt = 2 ** -1   //幂运算   0.5

def numbers = [1,2,3]
numbers.size()
numbers[0]
numbers.add(4)
numbers[-1] == 3    //用一个负数索引来访问最尾的元素：-1是从尾部算起的第一个元素
numbers << 3        //使用<<左移动操作符添加一个元素到列表的最后
numbers[0, 2] == [1,3]
numbers[0..2] = ['a', 'b', 'c']

def heterogeneous = [1, 'a', "a", true]


























