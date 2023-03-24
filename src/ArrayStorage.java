import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i = 0;
        while (storage[i] != null) {
            storage[i++] = null;
        }
    }

    void save(Resume r) {
        int size = size();
        if (size >= storage.length) {
            System.out.println("Arrays is full. Not possible to save new resume");
            return;
        }
        storage[size] = r;
    }

    Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        return null;
    }

    int findIndex(String uuid) {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            return;
        }
        for (int i = index; i < (storage.length - 1); i++) {
            storage[i] = storage[i + 1];
            if (storage[i + 1] == null) {
                return;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size = size();
        return Arrays.copyOf(storage, size);
    }

    int size() {
        int i = 0;
        while (storage[i] != null) {
            i++;
        }
        return i;
    }
}
