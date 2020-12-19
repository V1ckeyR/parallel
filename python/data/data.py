from random import randint
from enum import Enum
import numpy as np


class Data:
    def __init__(self, n):
        self.N = n

    class Method(Enum):
        KEYBOARD = 1
        FILE = 2
        NUMBER = 3
        RANDOM = 4

    def get_keyboard_matrix(self):
        print("Enter matrix in a single line (separated by space): ")
        entries = list(map(int, raw_input().split(' ')))
        return np.array(entries).reshape(self.N, self.N)

    @staticmethod
    def get_keyboard_vector():
        print("Enter vector in a single line (separated by space): ")
        entries = map(int, raw_input().split())
        return np.array(entries)

    @staticmethod
    def get_keyboard_scalar():
        return int(raw_input("Enter scalar: "))

    def get_file_matrix(self, filename):
        return np.loadtxt(filename, usecols=range(self.N), dtype=int)

    @staticmethod
    def get_file_vector(filename):
        return np.loadtxt(filename, dtype=int)

    @staticmethod
    def get_file_scalar(filename):
        f = open(filename)
        a = f.read()
        f.close()
        return int(a)

    def get_number_matrix(self, number):
        return np.full((self.N, self.N), number)

    def get_number_vector(self, number):
        return np.full(self.N, number)

    def get_random_matrix(self):
        return np.random.randint(10, size=(self.N, self.N))

    def get_random_vector(self):
        return np.random.randint(10, size=self.N)

    @staticmethod
    def get_random_scalar():
        return randint(-10, 10)
