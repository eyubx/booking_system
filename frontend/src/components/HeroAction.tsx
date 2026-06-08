import {InputGroup, InputGroupAddon, InputGroupInput} from "@/components/ui/input-group.tsx";
import {Button} from "@/components/ui/button.tsx";

import {
    Select,
    SelectContent,
    SelectItem,
    SelectTrigger,
    SelectValue
} from "@/components/ui/select.tsx";
import {useState} from "react";

export default function HeroAction() {
    const [selectedField, setSelectedField] = useState<string>("");
    // const [searchText, setSearchText] = useState<string>("");
    // const handleSubmit = (e) => {
    //     e.preventDefault();
    //     alert('Hello submitted');
    // }
    return (
        <form action="/search">
            <div className="flex w-full mb-4">
                <InputGroup className="flex border border-gray-600 gap-4 py-4">
                    <InputGroupInput placeholder="Search your expert" className="p-2" name="expert"/>
                    <InputGroupAddon align="inline-end">
                        <Select name="field" defaultValue={selectedField}
                                onValueChange={(e: string): void => setSelectedField(e)}
                        >
                            <SelectTrigger className="w-full max-w-48">
                                <SelectValue placeholder="Select a field"/>
                            </SelectTrigger>
                            <SelectContent>
                                <SelectItem value="field1">Field 1</SelectItem>
                                <SelectItem value="field2">Field 2</SelectItem>
                                <SelectItem value="field3">Field 3</SelectItem>
                            </SelectContent>
                        </Select>
                    </InputGroupAddon>
                </InputGroup>
                <Button type="submit" className="cursor-pointer">Get Started</Button>
            </div>
        </form>
    );
}