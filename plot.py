#!/usr/bin/env python
import numpy as np
import sys, os
import matplotlib.pyplot as plt
import pylab


from numpy import genfromtxt

if __name__ == '__main__':
    plot_title = "Conway"
    out_dir = None
    if len(sys.argv) > 1:   
        plot_title = sys.argv[1]
    if len(sys.argv) > 2:
    	out_dir = sys.argv[2]

    data = genfromtxt(sys.stdin, delimiter=';')
    data = data[:, 1:3]
    results = []
    for x in sorted(np.unique(data[:,0])):
        results.append([x, np.average(data[np.where(data[:,0]==x)][:,1])])
    data = np.array(results)

    plt.plot(data[:,0], data[:,1])
    plt.title(plot_title)
    if out_dir:
    	plt.savefig(os.path.join(out_dir, plot_title+".png"))
    else:
    	pylab.show()
