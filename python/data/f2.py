from data import Data
import numpy as np


def f2(comm, n, method):
    data = Data(n)
    if n > 1000:
        if method is Data.Method.FILE:
            ml = data.get_file_matrix('asset/ML.txt')
            mh = data.get_file_matrix('asset/MH.txt')
            mg = data.get_file_matrix('asset/MG.txt')
        elif method is Data.Method.NUMBER:
            ml = data.get_number_matrix(2)
            mh = data.get_number_matrix(2)
            mg = data.get_number_matrix(2)
        elif method is Data.Method.RANDOM:
            ml = data.get_random_matrix()
            mh = data.get_random_matrix()
            mg = data.get_random_matrix()
        else:
            raise Exception("Incorrect method.")
    elif n < 5:
        print "f2 reading"
        ml = data.get_keyboard_matrix()
        mh = data.get_keyboard_matrix()
        mg = data.get_keyboard_matrix()
        comm.Barrier()
    else:
        raise Exception("N should be less than 5 or more that 1000.")

    mk = ml + np.dot(mh, mg)
    print 'MK =\n', mk
