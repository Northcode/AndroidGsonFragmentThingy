package no.northcode.jsondata;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by andreas on 20/02/17.
 */

public class PersonParccel implements Parcelable {

    Person p;

    public PersonParccel(Person p) {
            this.p = p;
    }

    public PersonParccel(Parcel pack) {
        String username = pack.readString();
        String firstname = pack.readString();
        String lastname = pack.readString();
        String password = pack.readString();
        String phone = pack.readString();
        int id = pack.readInt();
        boolean[] tmp = new boolean[1];
        pack.readBooleanArray(tmp);
        this.p = new Person(username, password, firstname, lastname, phone, tmp[0]);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(p.getUserName());
        parcel.writeString(p.getFirstname());
        parcel.writeString(p.getLastname());
        parcel.writeString(p.getPassword());
        parcel.writeString(p.getPhone());
        parcel.writeInt(p.getU_id());
        parcel.writeBooleanArray(new boolean[] { p.isUser_activated() } );
    }

    public static Parcelable.Creator<PersonParccel> CREATOR = new Parcelable.Creator<PersonParccel>() {

        @Override
        public PersonParccel createFromParcel(Parcel parcel) {
            return new PersonParccel(parcel);
        }

        @Override
        public PersonParccel[] newArray(int i) {
            return new PersonParccel[i];
        }
    };
}
