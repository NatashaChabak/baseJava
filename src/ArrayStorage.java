import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
             storage[i++] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    void save(Resume r) {
        if (size >= storage.length) {
            System.out.println("Arrays is full. Not possible to save new resume");
            return;
        } else if (findIndex(r.uuid) > 0) {
            System.out.println("Resume already exists in the list");
            return;
        }
        storage[size++] = r;
    }

    Resume get(String uuid) {
        int index = findIndex(uuid);
        return index >= 0 ? storage[index] : null;
    }

    void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
