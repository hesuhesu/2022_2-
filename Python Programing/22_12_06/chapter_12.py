{
 "cells": [
  {
   "cell_type": "markdown",
   "metadata": {
    "id": "tBxHmZgQKODG"
   },
   "source": [
    "# 데이터과학 파이썬 12장 도전문제와 심화문제 풀이"
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {
    "id": "i_ZRdpwUdd5S"
   },
   "source": [
    "### 심화문제 12.1"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 1,
   "metadata": {
    "id": "QSTTttSs4CK2"
   },
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "            평균기온  최대풍속  평균풍속\n",
      "일시                          \n",
      "2010-08-01  28.7   8.3   3.4\n",
      "2010-08-02  25.2   8.7   3.8\n",
      "2010-08-03  22.1   6.3   2.9\n",
      "            평균기온  최대풍속  평균풍속\n",
      "일시                          \n",
      "2020-07-29  21.6   3.2   1.0\n",
      "2020-07-30  22.9   9.7   2.4\n",
      "2020-07-31  25.7   4.8   2.5\n"
     ]
    }
   ],
   "source": [
    "import pandas as pd\n",
    "\n",
    "weather = pd.read_csv('https://raw.githubusercontent.com/dongupak/DataSciPy/master/data/csv/weather.csv', index_col = 0, encoding='CP949')\n",
    "print(weather.head(3))\n",
    "print(weather.tail(3))"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 2,
   "metadata": {
    "id": "kyetIYGh4LKU"
   },
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "평균기온    16.6\n",
      "최대풍속     4.4\n",
      "평균풍속     1.9\n",
      "Name: 2015-06-06, dtype: float64\n"
     ]
    }
   ],
   "source": [
    "import pandas as pd\n",
    "\n",
    "weather = pd.read_csv('https://raw.githubusercontent.com/dongupak/DataSciPy/master/data/csv/weather.csv', index_col = 0, encoding='CP949')\n",
    "\n",
    "print(weather.loc['2015-06-06'])"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 3,
   "metadata": {
    "id": "BfASF8z04Mhs"
   },
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "31.3\n"
     ]
    }
   ],
   "source": [
    "import pandas as pd\n",
    "\n",
    "weather = pd.read_csv('https://raw.githubusercontent.com/dongupak/DataSciPy/master/data/csv/weather.csv', index_col = 0, encoding='CP949')\n",
    "\n",
    "print(weather['평균기온'].max())"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 4,
   "metadata": {
    "id": "h-t1_nkz4OHd"
   },
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "            평균기온  최대풍속  평균풍속\n",
      "일시                          \n",
      "2013-08-08  31.3   7.8   4.6\n"
     ]
    }
   ],
   "source": [
    "import pandas as pd\n",
    "\n",
    "weather = pd.read_csv('https://raw.githubusercontent.com/dongupak/DataSciPy/master/data/csv/weather.csv', index_col = 0, encoding='CP949')\n",
    "\n",
    "print(weather[weather['평균기온'] == weather['평균기온'].max()])"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 5,
   "metadata": {
    "id": "mW5arok14TfE"
   },
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "            평균기온  최대풍속  평균풍속\n",
      "일시                          \n",
      "2013-08-08  31.3   7.8   4.6\n",
      "2013-08-09  30.6   9.9   6.4\n",
      "2013-08-10  30.6   7.4   3.8\n",
      "2018-07-23  30.5   6.5   1.6\n",
      "2018-08-04  30.3   5.8   3.0\n"
     ]
    }
   ],
   "source": [
    "import pandas as pd\n",
    "\n",
    "weather = pd.read_csv('https://raw.githubusercontent.com/dongupak/DataSciPy/master/data/csv/weather.csv', index_col = 0, encoding='CP949')\n",
    "\n",
    "print(weather[weather['평균기온'] >= 30.0 ])"
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {
    "id": "KAJ4ypyc0r2V"
   },
   "source": [
    "### 심화문제 12.2"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 6,
   "metadata": {
    "id": "ufHSEog34Qr8"
   },
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "      horse power  weight  efficiency\n",
      "name                                 \n",
      "A             130     1.9        16.3\n",
      "B             250     2.6        10.2\n",
      "C             190     2.2        11.1\n"
     ]
    }
   ],
   "source": [
    "import pandas as pd\n",
    "\n",
    "df = pd.DataFrame({\n",
    "   'name' : ['A', 'B', 'C', 'D', 'E', 'F', 'G'],\n",
    "    'horse power' : [130, 250, 190, 300, 210, 220, 170],\n",
    "    'weight' : [1.9, 2.6, 2.2, 2.9, 2.4, 2.3, 2.2],\n",
    "    'efficiency': [16.3, 10.2, 11.1, 7.1, 12.1, 13.2, 14.2] })\n",
    "df = df.set_index('name')\n",
    "print(df.head(3))"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 7,
   "metadata": {
    "id": "GbGo6xdF4WGc"
   },
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "      horse power  weight  efficiency\n",
      "name                                 \n",
      "D             300     2.9         7.1\n"
     ]
    }
   ],
   "source": [
    "import pandas as pd\n",
    "\n",
    "df = pd.DataFrame({\n",
    "   'name' : ['A', 'B', 'C', 'D', 'E', 'F', 'G'],\n",
    "    'horse power' : [130, 250, 190, 300, 210, 220, 170],\n",
    "    'weight' : [1.9, 2.6, 2.2, 2.9, 2.4, 2.3, 2.2],\n",
    "    'efficiency': [16.3, 10.2, 11.1, 7.1, 12.1, 13.2, 14.2] })\n",
    "df = df.set_index('name')\n",
    "\n",
    "print(df[df['horse power'] == df['horse power'].max()])"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 8,
   "metadata": {
    "id": "E0MbmQtt4Xy9"
   },
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "      horse power  weight  efficiency  hp x mile\n",
      "name                                            \n",
      "F             220     2.3        13.2     2904.0\n"
     ]
    }
   ],
   "source": [
    "import pandas as pd\n",
    "\n",
    "df = pd.DataFrame({\n",
    "   'name' : ['A', 'B', 'C', 'D', 'E', 'F', 'G'],\n",
    "    'horse power' : [130, 250, 190, 300, 210, 220, 170],\n",
    "    'weight' : [1.9, 2.6, 2.2, 2.9, 2.4, 2.3, 2.2],\n",
    "    'efficiency': [16.3, 10.2, 11.1, 7.1, 12.1, 13.2, 14.2] })\n",
    "df = df.set_index('name')\n",
    "\n",
    "df['hp x mile'] = df['horse power'] * df['efficiency']\n",
    "\n",
    "print(df[df['hp x mile'] == df['hp x mile'].max()])"
   ]
  },
  {
   "cell_type": "markdown",
   "metadata": {
    "id": "2T3dNjYe0sP5"
   },
   "source": [
    "### 심화문제 12.3"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 9,
   "metadata": {
    "id": "9eyTML9H4aeL"
   },
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "      horse power  weight  efficiency\n",
      "name                                 \n",
      "A             120     1.9        18.3\n",
      "B             220     2.1        19.2\n",
      "C             120     1.5        21.1\n",
      "D             200     2.9        17.3\n"
     ]
    }
   ],
   "source": [
    "import pandas as pd\n",
    "\n",
    "df = pd.DataFrame({\n",
    "   'name' : ['A', 'B', 'C', 'D'],\n",
    "    'horse power' : [120, 220, 120, 200],\n",
    "    'weight' : [1.9, 2.1, 1.5, 2.9],\n",
    "    'efficiency': [18.3, 19.2, 21.1, 17.3] })\n",
    "df = df.set_index('name')\n",
    "\n",
    "print(df)"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 10,
   "metadata": {
    "id": "TAUyIKl84cFt"
   },
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "      horse power  weight  efficiency\n",
      "name                                 \n",
      "A             130     1.9        16.3\n",
      "B             250     2.6        10.2\n",
      "C             190     2.2        11.1\n",
      "D             300     2.9         7.1\n",
      "E             210     2.4        12.1\n",
      "F             220     2.3        13.2\n",
      "G             170     2.2        14.2\n",
      "A             120     1.9        18.3\n",
      "B             220     2.1        19.2\n",
      "C             120     1.5        21.1\n",
      "D             200     2.9        17.3\n"
     ]
    }
   ],
   "source": [
    "import pandas as pd\n",
    "\n",
    "df_1 = pd.DataFrame({\n",
    "   'name' : ['A', 'B', 'C', 'D', 'E', 'F', 'G'],\n",
    "    'horse power' : [130, 250, 190, 300, 210, 220, 170],\n",
    "    'weight' : [1.9, 2.6, 2.2, 2.9, 2.4, 2.3, 2.2],\n",
    "    'efficiency': [16.3, 10.2, 11.1, 7.1, 12.1, 13.2, 14.2] })\n",
    "\n",
    "df_2 = pd.DataFrame({\n",
    "   'name' : ['A', 'B', 'C', 'D'],\n",
    "    'horse power' : [120, 220, 120, 200],\n",
    "    'weight' : [1.9, 2.1, 1.5, 2.9],\n",
    "    'efficiency': [18.3, 19.2, 21.1, 17.3] })\n",
    "\n",
    "df_3 = pd.concat([df_1, df_2])\n",
    "\n",
    "df_3 = df_3.set_index('name')\n",
    "\n",
    "print(df_3)"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 11,
   "metadata": {
    "id": "cHIz07tC4do1"
   },
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "      horse power  weight  efficiency com\n",
      "name                                     \n",
      "A             130     1.9        16.3   P\n",
      "B             250     2.6        10.2   P\n",
      "C             190     2.2        11.1   P\n",
      "D             300     2.9         7.1   P\n",
      "E             210     2.4        12.1   P\n",
      "F             220     2.3        13.2   P\n",
      "G             170     2.2        14.2   P\n",
      "A             120     1.9        18.3   Q\n",
      "B             220     2.1        19.2   Q\n",
      "C             120     1.5        21.1   Q\n",
      "D             200     2.9        17.3   Q\n"
     ]
    }
   ],
   "source": [
    "import pandas as pd\n",
    "\n",
    "df_1 = pd.DataFrame({\n",
    "   'name' : ['A', 'B', 'C', 'D', 'E', 'F', 'G'],\n",
    "    'horse power' : [130, 250, 190, 300, 210, 220, 170],\n",
    "    'weight' : [1.9, 2.6, 2.2, 2.9, 2.4, 2.3, 2.2],\n",
    "    'efficiency': [16.3, 10.2, 11.1, 7.1, 12.1, 13.2, 14.2] })\n",
    "df_1['com'] = 'P'\n",
    "\n",
    "df_2 = pd.DataFrame({\n",
    "   'name' : ['A', 'B', 'C', 'D'],\n",
    "    'horse power' : [120, 220, 120, 200],\n",
    "    'weight' : [1.9, 2.1, 1.5, 2.9],\n",
    "    'efficiency': [18.3, 19.2, 21.1, 17.3] })\n",
    "df_2['com'] = 'Q'\n",
    "\n",
    "df_3 = pd.concat([df_1, df_2])\n",
    "\n",
    "df_3 = df_3.set_index('name')\n",
    "\n",
    "print(df_3)"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 12,
   "metadata": {
    "id": "FQxAXOiq4f68"
   },
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "com\n",
      "P    2395.285714\n",
      "Q    3103.000000\n",
      "Name: hp x mile, dtype: float64\n"
     ]
    }
   ],
   "source": [
    "import pandas as pd\n",
    "\n",
    "df_1 = pd.DataFrame({\n",
    "   'name' : ['A', 'B', 'C', 'D', 'E', 'F', 'G'],\n",
    "    'horse power' : [130, 250, 190, 300, 210, 220, 170],\n",
    "    'weight' : [1.9, 2.6, 2.2, 2.9, 2.4, 2.3, 2.2],\n",
    "    'efficiency': [16.3, 10.2, 11.1, 7.1, 12.1, 13.2, 14.2] })\n",
    "df_1['com'] = 'P'\n",
    "\n",
    "df_2 = pd.DataFrame({\n",
    "   'name' : ['A', 'B', 'C', 'D'],\n",
    "    'horse power' : [120, 220, 120, 200],\n",
    "    'weight' : [1.9, 2.1, 1.5, 2.9],\n",
    "    'efficiency': [18.3, 19.2, 21.1, 17.3] })\n",
    "df_2['com'] = 'Q'\n",
    "\n",
    "df_3 = pd.concat([df_1, df_2])\n",
    "df_3['hp x mile'] = df_3['horse power'] * df_3['efficiency']\n",
    "\n",
    "df_3 = df_3.set_index('name')\n",
    "\n",
    "print(df_3.groupby('com').mean()['hp x mile'])"
   ]
  }
 ],
 "metadata": {
  "colab": {
   "collapsed_sections": [],
   "name": "12장_도전문제_심화문제.ipynb",
   "provenance": []
  },
  "kernelspec": {
   "display_name": "Python 3 (ipykernel)",
   "language": "python",
   "name": "python3"
  },
  "language_info": {
   "codemirror_mode": {
    "name": "ipython",
    "version": 3
   },
   "file_extension": ".py",
   "mimetype": "text/x-python",
   "name": "python",
   "nbconvert_exporter": "python",
   "pygments_lexer": "ipython3",
   "version": "3.8.13"
  }
 },
 "nbformat": 4,
 "nbformat_minor": 4
}
