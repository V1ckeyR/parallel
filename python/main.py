from mpi4py import MPI
from data import *

comm = MPI.COMM_WORLD
rank = comm.Get_rank()

if rank == 0:
    f1(comm, 3, Data.Method.KEYBOARD)
elif rank == 1:
    f2(comm, 3, Data.Method.KEYBOARD)

MPI.Finalize()
