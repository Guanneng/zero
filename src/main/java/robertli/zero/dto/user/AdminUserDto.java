/*
 * Copyright 2016 Robert Li.
 * Released under the MIT license
 * https://opensource.org/licenses/MIT
 */
package robertli.zero.dto.user;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @version 1.0 2016-12-30
 * @author Robert Li
 */
public class AdminUserDto {

    private Integer id;
    private String username;
    private String password;
    private boolean locked;
    private boolean root;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "AdminUserDto{" + "id=" + id + ", username=" + username + ", password=" + password + ", locked=" + locked + ", root=" + root + '}';
    }

}
