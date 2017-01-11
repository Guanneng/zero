import * as React from "react";
import { connect } from "react-redux"
import { store, AppState } from "../../Store"
import { UserProfile } from "../../reducers/me"
import { Button, ButtonToolbar, Row, Col, Panel } from "react-bootstrap";
import * as zform from "../../components/zero/ZForm"
import * as ztable from "../../components/zero/ZTable"
import { http, RestErrorDto } from "../../utilities/http"

type AdminUserDto = {
    id: number
    username: string
    password: string
    locked: boolean
    root: boolean
}

interface Props {
    me: UserProfile
}

interface State {
    adminUserList: AdminUserDto[]
}

class AdminUserAdminComponent extends React.Component<Props, State>{

    constructor(prop: Props) {
        super(prop);
        this.state = { adminUserList: [] }
        this.updateData();
    }

    updateData() {
        return http.get("admin-users")
            .then((adminUserList: AdminUserDto[]) => {
                this.state.adminUserList = adminUserList;
                this.setState(this.state);
            });
    }

    onAddSuccess() {
        this.updateData()
    }

    onDelete(adminUser: AdminUserDto) {
        const url = "admin-users/" + adminUser.username
        http.delete(url)
            .then(() => {
                this.updateData();
            })
            .catch((error: RestErrorDto) => {
                console.log(error);
            })
    }

    render() {
        return (
            <div className="container">
                <h1>Admin Editor</h1>
                <Row>
                    <Col sm={3}>
                        <Panel header="Add Admin" bsStyle="primary">
                            <zform.Form action="admin-users" method="POST" onSuccess={this.onAddSuccess.bind(this)}>
                                <zform.TextField label="username" name="username" enterSubmit={false} />
                                <zform.Password label="password" name="password" enterSubmit={true} />
                                <zform.Hidden name="locked" value="false" />
                                <zform.Hidden name="root" value="false" />
                                <zform.Submit value="add" />
                            </zform.Form>
                        </Panel>
                        <Panel header="Reset Admin Password" bsStyle="primary">
                            <zform.Form action="admin-users/{username}/password" method="PUT" successMessage="reset password">
                                <zform.TextField label="username" name="username" place="pathAndDto" />
                                <zform.Password label="password" name="password" enterSubmit={true} />
                                <zform.Submit value="reset" />
                            </zform.Form>
                        </Panel>
                    </Col>
                    <Col sm={9}>
                        <Panel header="Admin List" bsStyle="primary">
                            <ztable.Table dtoList={this.state.adminUserList} >
                                <ztable.ColButton name="delete" bsStyle="danger" bsSize="xs" onAction={this.onDelete.bind(this)} />
                            </ztable.Table>
                        </Panel>
                    </Col>
                </Row>
            </div>
        );
    }
}

function select(state: AppState): Props {
    return { me: state.me };
}

export let AdminUserAdmin = connect(select)(AdminUserAdminComponent);