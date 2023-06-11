#include <iostream>
#include <fstream>
#include <vector>
#include <limits>
#include <string>

using namespace std;

int main() {
    ifstream reader("page.inp");
    ofstream writer("page.out");

    string line;
    getline(reader, line);
    int k = stoi(line);
    vector<vector<int>> FIFO_list(k, vector<int>(2, numeric_limits<int>::max()));
    vector<vector<int>> LRU_list(k, vector<int>(2, numeric_limits<int>::max()));
    vector<int> OPT_list(k, numeric_limits<int>::max());
    vector<int> reference_string;

    int FIFO = 0;
    int LRU = 0;
    int OPT = 0;
    int time = 0;

    for (int i = 0; i < k; i++) {
        FIFO_list[i][0] = -1;
        FIFO_list[i][1] = -1;

        LRU_list[i][0] = -1;
        LRU_list[i][1] = -1;
    }

    while (getline(reader, line)) {
        if (line == "-1") {
            break;
        }
        reference_string.push_back(stoi(line));
    }

    for (int i = 0; i < reference_string.size(); i++) {
        time++;

        int FIFO_count = 0;
        int LRU_count = 0;
        int OPT_count = 0;

        for (int j = 0; j < k; j++) {
            if (FIFO_list[j][0] == -1) {
                FIFO_list[j][0] = reference_string[i];
                FIFO_list[j][1] = time;
                FIFO_count++;
                FIFO++;
                break;
            }
            if (FIFO_list[j][0] == reference_string[i]) {
                FIFO_count++;
                break;
            }
        }
        if (FIFO_count == 0) {
            int FIFO_sort = time;
            int FIFO_index = 0;
            for (int j = 0; j < k; j++) {
                if (FIFO_sort > FIFO_list[j][1]) {
                    FIFO_sort = FIFO_list[j][1];
                    FIFO_index = j;
                }
            }
            FIFO_list[FIFO_index][0] = reference_string[i];
            FIFO_list[FIFO_index][1] = time;
            FIFO++;
           }

        for (int j = 0; j < k; j++) {
            if (LRU_list[j][0] == -1) {
                LRU_list[j][0] = reference_string[i];
                LRU_list[j][1] = time;
                LRU_count++;
                LRU++;
                break;
            }

            if (LRU_list[j][0] == reference_string[i]) {
                LRU_list[j][1] = time;
                LRU_count++;
                break;
            }
        }

        if (LRU_count == 0) {
            int LRU_sort = time;
            int LRU_index = 0;
            for (int j = 0; j < k; j++) {
                if (LRU_sort > LRU_list[j][1]) {
                    LRU_sort = LRU_list[j][1];
                    LRU_index = j;
                }
            }
            LRU_list[LRU_index][0] = reference_string[i];
            LRU_list[LRU_index][1] = time;
            LRU++;
            }


        for (int j = 0; j < k; j++) {
            if (OPT_list[j] == numeric_limits<int>::max()) {
                OPT_list[j] = reference_string[i];
                OPT_count++;
                OPT++;
                break;
            }

            if (OPT_list[j] == reference_string[i]) {
                OPT_count++;
                break;
            }
        }

        if (OPT_count == 0) {
            int OPT_sort = reference_string.size();
            int OPT_index = 0;
            vector<int> OPT_test(k, reference_string.size());

            for (int j = 0; j < k; j++) {
                for (int w = i; w < reference_string.size(); w++) {
                    if (reference_string[w] == OPT_list[j]) {
                        OPT_test[j] = w;
                        break;
                    }
                }
            }

            int count2 = 0;
            for (int j = 0; j < k; j++) {
                if (OPT_test[j] == reference_string.size()) {
                    OPT_index = j;
                    count2++;
                    break;
                }
            }

            if (count2 == 0) {
                OPT_sort = OPT_test[0];
                for (int j = 0; j < k; j++) {
                    if (OPT_sort < OPT_test[j]) {
                        OPT_sort = OPT_test[j];
                        OPT_index = j;
                    }
                }
            }

           OPT_list[OPT_index] = reference_string[i];
           OPT++;
         }

        }

    writer << "FIFO: " << FIFO << endl;
    writer << "LRU: " << LRU << endl;
    writer << "OPT: " << OPT << endl;

    reader.close();
    writer.close();
    return 0;
}
