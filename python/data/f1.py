from data import Data
import numpy as np


def f1(comm, n, method):
    data = Data(n)
    if n > 1000:
        if method is Data.Method.FILE:
            mo = data.get_file_matrix('asset/MO.txt')
            mp = data.get_file_matrix('asset/MO.txt')
            r = data.get_file_vector('asset/R.txt')
            s2 = data.get_file_vector('asset/S2.txt')
            v = data.get_file_scalar('asset/v.txt')
        elif method is Data.Method.NUMBER:
            mo = data.get_number_matrix(1)
            mp = data.get_number_matrix(1)
            r = data.get_number_vector(1)
            s2 = data.get_number_vector(1)
            v = 1
        elif method is Data.Method.RANDOM:
            mo = data.get_random_matrix()
            mp = data.get_random_matrix()
            r = data.get_random_vector()
            s2 = data.get_random_vector()
            v = data.get_random_scalar()
        else:
            raise Exception("Incorrect method.")
    elif n < 5:
        comm.Barrier()
        print "f1 reading"
        mo = data.get_keyboard_matrix()
        mp = data.get_keyboard_matrix()
        r = data.get_keyboard_vector()
        s2 = data.get_keyboard_vector()
        v = data.get_keyboard_scalar()
    else:
        raise Exception("N should be less than 5 or more that 1000.")

    s = np.dot(mo, mp).dot(r) + s2 * v
    print 'S =', s
